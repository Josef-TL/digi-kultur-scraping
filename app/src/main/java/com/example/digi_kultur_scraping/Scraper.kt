package com.example.digi_kultur_scraping

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver


fun main(){
    val driver = ChromeDriver()
    driver.get("https://www.hackernews.com");
    val titleListWeb: List<WebElement> = driver.findElements(By.className("titleline"))
    val pointListWeb: List<WebElement> = driver.findElements(By.className("score"))
    val commentListWeb: List<WebElement> = driver.findElements(By.xpath("//*[@class=\"subline\"]/a[3]"))



    val pointList: List<Int> = getIntListFromWebElementList(pointListWeb)
    val commentList: List<Int> = getIntListFromWebElementList(commentListWeb)

    val newsPosts: ArrayList<HackernewsPost> = ArrayList<HackernewsPost>()


    for (i in 0..28){
        val currentPost: HackernewsPost = HackernewsPost(titleListWeb[i].text,pointList[i],commentList[i])
        newsPosts.add(currentPost)
    }

    println(newsPosts)


    driver.quit();
}

fun getIntListFromWebElementList(l: List<WebElement>): List<Int> {
    val retList: MutableList<Int> = mutableListOf()
    for (elem in l) {
        val temp: String = elem.text
        val temp2: String = temp.filter { it.isDigit() }
        if (temp2 == "") {
            retList.add(0)
        } else {
            retList.add(temp2.toInt())
        }
    }
    return retList.toList()
}
