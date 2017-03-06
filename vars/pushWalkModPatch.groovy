#!/usr/bin/env groovy

/**
 * Commits and pushes a WalkMod patch
 */
def call(String branch = 'master') {

    sh 'git commit -a --fixup HEAD'

    sh "git pull --rebase origin $branch"

    sh "git push origin HEAD:$branch"


}
