#!/usr/bin/env groovy

/**
 * Checks if there is a pending WalkMod patch to apply
 */
def call() {


  if (fileExists('walkmod.patch')) {
    sh 'rm walkmod.patch'
  }

  echo "gradle walkmodPatch"

  sh "gradle walkmodPatch"
  return fileExists('walkmod.patch')

}
