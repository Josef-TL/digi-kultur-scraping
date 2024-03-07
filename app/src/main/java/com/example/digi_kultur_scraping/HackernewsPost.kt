package com.example.digi_kultur_scraping

data class HackernewsPost(val title: String, val points: Int, val numberOfComments: Int): Comparable<HackernewsPost> {
    override fun compareTo(other: HackernewsPost): Int {
        TODO("Not yet implemented")
    }
};