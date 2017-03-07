# jenkins-pipeline-shared

This is a Jenkins pipeline to run WalkMod. It allows to review the applied changes of walkmod or push when all tests are successful.

An example of pipeline that integrates this library is: 

```
#!groovy
@Library('github.com/walkmod/jenkins-pipeline-shared@master') _

node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'REPLACE_BY_YOUR_GIT_URL'
      mvnHome = tool 'M3'
   }   
   stage ('Fixing Release'){
      walkmodApply { 
        mvnHomeDir = "${mvnHome}"
      }        
   }   
   stage('Build') {
      sh "${mvnHome}/bin/mvn -DskipWalkmod package"     
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }

}
