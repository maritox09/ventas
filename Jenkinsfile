def fallo = ''
pipeline{
   agent  {
      node {
        label 'principal'
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
         sh 'mvn package'
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
     stage("Quality Gate"){
        steps {
            script {
                fallo=env.STAGE_NAME
                echo "Quality Gate"
                timeout(time: 1, unit: 'HOURS') {
                   def qg = waitForQualityGate()
                   if (qg.status != 'OK') {
                     error "Pipeline aborted due to quality gate failure: ${qg.status}"
                   }
                 }
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
