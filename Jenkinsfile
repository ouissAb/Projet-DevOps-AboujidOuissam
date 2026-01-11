pipeline {
    agent any

    tools {
        // Nom que tu as configuré dans Jenkins → Global Tool Configuration
        jdk 'Java 17'
        maven 'Maven 3.8.7'
    }

    environment {
        // Nom du canal Slack
        SLACK_CHANNEL = '#devops-test1'
    }

    stages {

        // 1️⃣ Récupérer le code depuis GitHub
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ouissAb/Projet-DevOps-AboujidOuissam.git'
            }
        }

        // 2️⃣ Build + Test
        stage('Build & Test') {
            steps {
                sh 'mvn clean install'
                sh 'mvn test'
            }
        }

        // 3️⃣ Archiver le .jar généré
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }

        // 4️⃣ Déploiement (simulé ici pour un mini-projet)
        stage('Deploy') {
            steps {
                sh 'echo "Déploiement simulé sur serveur local ou cloud"'
            }
        }

        // 5️⃣ Notification Slack si succès
        stage('Notify Slack') {
            steps {
                slackSend(channel: env.SLACK_CHANNEL,tokenCredentialId: 'slack-token', message: "✅ Pipeline terminé avec succès pour Projet-DevOps-AboujidOuissam")
            }
        }
    }

    // Actions post-build
    post {
        failure {
            slackSend(channel: env.SLACK_CHANNEL, message: "❌ Échec du pipeline pour Projet-DevOps-AboujidOuissam")
        }
    }
}
