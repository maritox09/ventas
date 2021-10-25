pipeline{
   agent any
   tools{
      maven 'Maven'
   }
   stages{
     stage('SCM Chekout'){
        steps{
         git 'https://github.com/maritox09/ventas'
         }
      }
     stage('Deploy container'){
        steps{
           sh 'cd target'
           deploy adapters: [tomcat9(credentialsId: '999', path: '', url: 'http://192.168.5.193:8086')], contextPath: 'rps', war: '**/*.war'
        }
     }
   }
}
