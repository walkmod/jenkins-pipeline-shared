#!/usr/bin/env groovy

/**
 * Applies a patch based on walkmod
 */
def call() {

  sh 'git apply walkmod.patch'

  echo 'walkmod.patch applied'

  sh 'rm walkmod.patch'

}
