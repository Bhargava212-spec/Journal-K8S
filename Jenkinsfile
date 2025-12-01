
pipeline {
    agent any

    environment {
        IMAGE_NAME = "journal-k8s"
        IMAGE_TAG = "v1"
        DEPLOYMENT_FILE = "deployment.yaml"
    }

   tools {
    maven 'Maven-3.9.11'
    }



    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/Bhargava212-spec/Journal-K8S',
                    credentialsId: 'github-creds'
            }
        }


        stage('Build JAR') {
            steps {
                  script {
                       echo "Building Spring Boot JAR..."
                       bat 'mvn -version'
                        bat 'mvn -Dmaven.test.failure.ignore=false clean package'
                        }
                  }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat "kubectl apply -f ${DEPLOYMENT_FILE}"
            }
        }

    }

    post {
        success {
            echo "Deployment successful!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
