package jonh.nery.businesscard

import android.app.Application
import jonh.nery.businesscard.data.AppDataBase
import jonh.nery.businesscard.data.BusinessCardRepository


class App : Application(){

    val dataBase by lazy { AppDataBase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(dataBase.businessDao()) }

}