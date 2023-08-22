pipeline {
    agent any
    
    stages {
        stage('Get-Code') {
            steps {
                checkout([
            $class: 'GitSCM',
            branches: [[name: 'main']], // Specify the branch you want to checkout
            userRemoteConfigs: [[url: 'https://github.com/Avenger422/Maven_Project.git']],
            credentialsId: 'b8eb44ea-4b3a-45fb-8787-42a80a787652' // Specify your credentials ID here
        ])
                }     
            }
            
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Deliver') {
            steps {
                sshagent(credentials: ['6e5d9cd7-af24-4897-b57b-6151b9cc0e28']) {
                    sh 'scp -o StrictHostKeyChecking=no target/my-app.war testuser@4.246.173.219:/home/testuser/apache-tomcat-9.0.78/webapps'
                }
            }
        }
    }
}
