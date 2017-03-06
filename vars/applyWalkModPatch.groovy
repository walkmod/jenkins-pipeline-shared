#!/usr/bin/env groovy

/**
 * Applies a patch based on walkmod
 */
def call() {

  sh 'git apply walkmod.patch'
  sh 'rm walkmod.patch'

}
