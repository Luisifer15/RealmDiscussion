package ph.edu.auf.luisalfonso.rimando.realmdiscussion

import android.app.Application
import ph.edu.auf.luisalfonso.rimando.realmdiscussion.database.RealmHelper

class RealmDiscussionApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RealmHelper.initializeRealm()
    }

    override fun onTerminate() {
        super.onTerminate()
        RealmHelper.closeRealm()
    }


}