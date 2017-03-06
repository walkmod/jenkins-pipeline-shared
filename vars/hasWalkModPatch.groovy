#!/usr/bin/env groovy

/**
 * Checks if there is a pending WalkMod patch to apply
 */
def call(String mvnHome = null) {

  if(mvnHome == null){
    return false;
  }

  if (fileExists('walkmod.patch')) {
    sh 'rm walkmod.patch'
  }

  echo "${mvnHome}/bin/mvn walkmod:patch"
  
  sh "${mvnHome}/bin/mvn walkmod:patch"
  return fileExists('walkmod.patch')

}
