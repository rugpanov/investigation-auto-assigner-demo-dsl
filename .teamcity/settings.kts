import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

version = "2019.1"

project {

    vcsRoot(HttpsGithubComJetBrainsTeamcityInvestigations)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(HttpsGithubComJetBrainsTeamcityInvestigations)
    }

    steps {
        gradle {
            name = "gradle - build"
            tasks = "clean build"
        }
    }

    triggers {
        vcs {
        }
    }


    features {
        investigationsAutoAssigner {
            enableDelayAssignments = true
        }
    }
    }
})

object HttpsGithubComJetBrainsTeamcityInvestigations : GitVcsRoot({
    name = "https://github.com/rugpanov/teamcity-investigations-auto-assigner.git#refs/heads/master"
    pollInterval = 20
    url = "https://github.com/rugpanov/teamcity-investigations-auto-assigner.git"
})

