
pipeline {

    agent any
    options {
        durabilityHint 'MAX_SURVIVABILITY'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Unit tests') {
            steps {
                sh './gradlew clean test --tests *Test'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }

        stage('Build bootJar') {
            steps {
                sh 'pwd;cd shop_kafka_consumer;./gradlew bootJar'
            }
        }

        stage('Publish to Nexus') {
            environment {
                NEXUS_CRED = credentials('nexus_admin')
            }
            steps {
                sh 'pwd;cd shop_kafka_consumer;./gradlew publish'
            }
        }
    }
}