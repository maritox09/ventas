def fallo = ''
pipeline{
   agent any
   tools{
      maven 'Maven'
   }
   stages{
     stage('SCM Chekout'){
        steps{
         git branch: 'master', url: 'https://github.com/maritox09/ventas/'
        }
     }
      stage('Compile-Package'){
        steps{
         sh 'mvn clean package'
        }
     }
     stage('SonarQube.Analysis'){
        steps{
           script{
              fallo=env.STAGE_NAME
              echo "Repositorio"
           }
           withSonarQubeEnv('sonarqube') {
              sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=chema10"
            }
        }
     }
     stage('Deploy container'){
        steps{
           deploy adapters: [tomcat9(credentialsId: '999', path: '', url: 'http://192.168.5.193:8088/')], contextPath: '/rps', war: '**/*.war'
        }
     }
   }
   post{
      failure{
         slackSend(channel: "general", color: '#FF88F4', message: "Project: ${currentBuild.currentResult} Job: ${env.JOB_NAME} URL: ${env.BUILD_URL} Buil Number: ${env.BUILD_NUMBER} Fallo: ${fallo}")
         mail bcc: '',
            body: "Project: ${currentBuild.currentResult} Job: ${env.JOB_NAME} URL: ${env.BUILD_URL} Buil Number: ${env.BUILD_NUMBER} Fallo: ${fallo}", 
            cc: '', 
            from: '', replyTo: '',
            subject: 'Pipeline fail', 
            to: 'jmyc9999@gmail.com'
      }
   }
}
