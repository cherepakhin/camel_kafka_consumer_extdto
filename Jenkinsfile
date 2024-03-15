pipeline {

    agent any
    options {
        durabilityHint 'MAX_SURVIVABILITY'
    }
    stages {
         stage('git clone') {
             steps {
             sh 'pwd'
             sh 'rm -r -f camel_kafka_consumer_extdto'
             sh 'git clone https://github.com/cherepakhin/camel_kafka_consumer_extdto.git'
             sh 'ls'
             }
         }
        stage('Unit tests') {
            steps {
                sh 'pwd;cd camel_kafka_consumer_extdto;./gradlew clean test --tests *Test'
            }
        }

        stage('Build') {
            steps {
                sh 'pwd;cd camel_kafka_consumer_extdto;./gradlew build'
            }
        }

        stage('Build bootJar') {
            steps {
                sh 'pwd;cd camel_kafka_consumer_extdto;./gradlew bootJar'
            }
        }

        stage('Publish to Nexus') {
            environment {
                NEXUS_CRED = credentials('nexus_admin')
            }
            steps {
                sh 'pwd;cd camel_kafka_consumer_extdto;./gradlew publish'
            }
        }
    }
}