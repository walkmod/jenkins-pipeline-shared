# jenkins-pipeline-shared

This is a Jenkins pipeline to run WalkMod. It allows to review the applied changes of walkmod or push when all tests are successful.

An example of pipeline that integrates this library is: 

```
#!groovy
@Library('github.com/walkmod/jenkins-pipeline-shared@maven') _

pipeline {
   agent any

   stages {

   stage ('Fixing Release'){
      steps {
         walkmodApply(validatePatch: true,
         branch: env.BRANCH_NAME,
         alwaysApply: true,
         alwaysFail: true)
      }
   }
   stage ('Check conventions'){
      steps {
         sh "mvn pmd:check"
      }
   }
   stage('Build') {
      steps {
         sh "mvn package"
      }
   }
   stage('Results') {
      steps {
          archive 'target/*.jar'
      }
   }
   }
}

