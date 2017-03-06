#!/usr/bin/env groovy

/**
 * Commits and pushes a WalkMod patch
 */
def call(String branch = 'master') {

    sh 'git commit -a --fixup'

    sh "git rebase -i --autosquash"

    sh "git push origin HEAD:$branch"


}
