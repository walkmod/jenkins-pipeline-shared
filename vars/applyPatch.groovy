#!/usr/bin/env groovy

/**
 * Send notifications based on build status string
 */
def call(String branch = 'master') {

  sh 'git apply walkmod.patch'
  sh 'rm walkmod.patch'
  sh 'git commit -a --amend -m "Fixing style violations"'
  sh 'git pull'
  sh 'git push origin HEAD:master'
  currentBuild.result = 'FAILURE'
  error("Build failed by the lack of consistent coding style")


}
