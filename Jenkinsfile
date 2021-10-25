def runner = { commandToExecute -> isUnix() ? sh(commandToExecute) : bat(commandToExecute) }

UnitTest:{
    stage("Unit testing"){
         node('nodomaven'){
        checkout("tests")

        try {
            runner 'cd tests && mvn test'
        } catch (err) {
             echo "Caught: ${err}"
            emailext attachLog: true, body: 'There was an error during "The Unit Testing" phase', subject: 'Something went wrong in the pipeline ', to: 'jmyc9999@gmail.com'
            error("Build failed during Unit testing")
        }

            
    }
}
}
SonarQube:{
    stage("SonarQube"){
        node('nodomaven'){
            checkout("tests")
            try {
                 withSonarQubeEnv('SonarQube') {
                    bat 'cd tests && mvn clean verify sonar:sonar -Dsonar.login=admin -Dsonar.password=chema10'
                }
        } catch (err) {
             echo "Caught: ${err}"
            emailext attachLog: true, body: 'There was an error during "SonarQube" phase', subject: 'Something went wrong in the pipeline ', to: 'jmyc9999@gmail.com'
            error("Build failed during SonarQube phase")
        }


        }
    }
    stage("Quality Gate") {
         try {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
        } catch (err) {
             echo "Caught: ${err}"
            emailext attachLog: true, body: 'The release does not meet the quality standards set by the lead developer', subject: 'Something went wrong in the pipeline ', to: 'jmyc9999@gmail.com'
            error("Build failed during Quality Gate phase")
        
        }
    }  
}


Production:{
    stage("Production"){
        node("nodomaven"){
            checkout("tests")
             try {
            runner 'cd tests && mvn package && cd target && dir' 
            deploy adapters: [tomcat9(credentialsId: '999', path: '', url: 'http://192.168.5.193:8888/')], contextPath: 'rps', war: '**/*.war'
        } catch (err) {
            echo "Caught: ${err}"
            emailext attachLog: true, body: 'There was an error during "The Unit Testing" phase', subject: 'Something went wrong in the pipeline ', to: 'jmyc9999@gmail.com'
            error("Build failed during Unit testing")
        }
        }
    }
}
