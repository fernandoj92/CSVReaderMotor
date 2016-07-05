import core.{Reader, DataSourceConfig, DataSource}

/**
  * Created by Fer on 05/07/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {

    val url = System.getProperty("user.dir") + "\\data\\iris-modified.csv"
    val url2 = "C:\\Users\\Fer\\Google Drive\\Masters\\Multiview Clustering\\Thesis\\Datos\\imputed\\imp_dataset_may16.csv"
    // println(url)
    // val dataSource = DataSource(DataSourceConfig(url,normalize = false))

    val base = List(2,5,8,11,14,17,20,23,26,29,32,35,38)
    val fieldsX = 0 :: base
    val fieldsY = 0 :: base.map(x => x-1)
    val fieldsZ = 0 :: base.map(x => x+1)

    Reader.showLines(url2, 2)

  }

}
