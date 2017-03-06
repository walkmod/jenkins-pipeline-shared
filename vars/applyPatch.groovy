#!/usr/bin/env groovy

/**
 * Commits and pushes a patch based on walkmod
 */
def call(String branch = 'master') {

  def functions = libraryResource 'walkmod/diffs/diff2html.sh'
  def ws = pwd tmp: true
  writeFile file: "$ws/diff2html.sh", text: functions
  sh "chmod u+x $ws/diff2html.sh"
  sh "cat walkmod.patch | $ws/diff2html.sh > $ws/walkmod.html"

  publishHTML target: [
    allowMissing: false,
    alwaysLinkToLastBuild: false,
    keepAll: true,
    reportDir: 'target',
    reportFiles: '$ws/walkmod.html',
    reportName: 'WalkMod Report'
  ]

  sh 'git apply walkmod.patch'
  sh 'rm walkmod.patch'
  sh 'git commit -a --amend -m "Fixing style violations"'
  sh "git pull origin $branch"
  sh "git push origin HEAD:$branch"
  currentBuild.result = 'FAILURE'
  error("Build failed by the lack of consistent coding style")


}
