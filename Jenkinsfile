pipeline{
   agent {
      node {
        label 'nodomaven'
         }
      }
   tools{
      maven 'Maven'
   }
   stages{
     stage('SCM Chekout'){
        steps{
         git 'https://github.com/maritox09/ventas'
        }
     }
     stage('Compile-Package'){
        steps{
         sh 'mvn clean package'
        }
     }
     stage('SonarQube.Analysis'){
        steps{
           withSonarQubeEnv('sonarqube') {
              sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=chema10"
            }
        }
    }
     stage('Deploy container'){
        steps{
           sh 'mvn tomcat7:deploy'
        }
     }
   }
}
