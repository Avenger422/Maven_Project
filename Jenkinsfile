pipeline {
    agent any
    
    stages {
        stage('Get-Code') {
            steps {
                checkout([
            $class: 'GitSCM',
            branches: [[name: 'main']], // Specify the branch you want to checkout
            userRemoteConfigs: [[url: 'https://github.com/Avenger422/Maven_Project.git']],
            credentialsId: 'f2840e72-0a66-4c57-91b1-529ea15441e0' // Specify your credentials ID here
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
                sshagent(credentials: ['15eb83c1-2e13-4ba8-b8dd-a4816dc5b4c3']) {
                    sh 'scp -o StrictHostKeyChecking=no target/HotelReservation-1.0-SNAPSHOT.war linuxuser@172.174.43.139:/home/linuxuser/apache-tomcat-9.0.78/webapps'
                }
            }
        }
    }
}
