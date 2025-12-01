package com.journal.common;

import com.journal.dto.UserEvent;
import com.journal.service.JournalService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Autowired
    private JournalService journalService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "user-events", groupId = "my-group")
    public void listen(ConsumerRecord<String, String> record) throws RuntimeException {
        logger.info("Received message:{}", record);
        logger.info("Key: {} ", record.key());
        logger.info("Value:{}", record.value());
        logger.info("Partition:{} ", record.partition());
        logger.info("Offset:{} ", record.offset());

        UserEvent userEvent = objectMapper.readValue(record.value(), UserEvent.class);

        journalService.saveUserEvent(userEvent);

    }
}
