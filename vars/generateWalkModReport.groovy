#!/usr/bin/env groovy

/**
 * Report a patch based on WalkMod
 */
def call(String reportDir = 'target') {

  def functions = libraryResource 'walkmod/diffs/diff2html.sh'
  def ws = pwd tmp: true
  writeFile file: "$ws/diff2html.sh", text: functions
  sh "chmod u+x $ws/diff2html.sh"
  sh "cat walkmod.patch | $ws/diff2html.sh > $reportDir/walkmod.html"

  sh "cat.walkmod.patch"
  
  publishHTML target: [
    allowMissing: false,
    alwaysLinkToLastBuild: true,
    keepAll: true,
    reportDir: reportDir,
    reportFiles: "walkmod.html",
    reportName: 'WalkMod Report'
  ]

}
