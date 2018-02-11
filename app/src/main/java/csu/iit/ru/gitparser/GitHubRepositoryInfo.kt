package csu.iit.ru.gitparser

/**
 * Created by user on 10.02.2018.
 */
data class GitHubRepositoryInfo(val name: String) {

    class List : ArrayList<GitHubRepositoryInfo>()
}