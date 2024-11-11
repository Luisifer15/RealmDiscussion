package ph.edu.auf.luisalfonso.rimando.realmdiscussion.database

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import ph.edu.auf.luisalfonso.rimando.realmdiscussion.database.realmmodel.OwnerModel
import ph.edu.auf.luisalfonso.rimando.realmdiscussion.database.realmmodel.PetModel

object RealmHelper {
    private lateinit var realmInstance : Realm

    fun initializeRealm() {
        val config = RealmConfiguration.Builder(schema = setOf(PetModel::class, OwnerModel::class))
            .name("petrealm.realm")
            .schemaVersion(2)
            .initialData{
                copyToRealm(PetModel().apply {
                    name = "DogMeat";
                    petType = "Dog";
                    age = 5;
                })
                copyToRealm(OwnerModel().apply {
                    name = "Yvan";
                    pets.addAll(listOf(PetModel().apply {
                        name = "Snow";
                        petType = "Dog";
                        age = 10;
                    }))
                })
            }
            .build()


        realmInstance = Realm.open(config)
    }

    fun getRealmInstance() : Realm {
        if(!::realmInstance.isInitialized) {
            throw IllegalStateException("Realm is not initialized. Call initializeRealm() first.")
        }
        return realmInstance
    }

    fun closeRealm() {
        if(::realmInstance.isInitialized && !realmInstance.isClosed()) {
            realmInstance.close()
        }
    }
}