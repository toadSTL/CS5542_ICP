

import org.apache.spark.sql.catalyst.expressions.{Ascending, Descending}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Mayanka on 09-Sep-15.
  * Updated by Gregory on 1-31-2019
  */
object SparkWordCount {

  def main(args: Array[String]) {

    System.setProperty("hadoop.home.dir","D:\\winutils")

    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

    val sc=new SparkContext(sparkConf)

    val input=sc.textFile("input", 1)

    val wc=input.flatMap(line=>{line.split(" ")}).sortBy[String]({(word:String) => word}).map(word=>(word(0),word+" ")).cache()

    val output=wc.reduceByKey(_+_)

    output.sortByKey(true).saveAsTextFile("output")

    val o=output.collect()

    var s:String="Words:Count \n"
    o.foreach{case(word,count)=>{

      s+=word+" : "+count+"\n"

    }}

  }

}
