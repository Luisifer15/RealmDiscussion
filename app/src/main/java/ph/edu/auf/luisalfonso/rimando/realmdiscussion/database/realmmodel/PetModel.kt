package ph.edu.auf.luisalfonso.rimando.realmdiscussion.database.realmmodel

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.UUID

class PetModel : RealmObject {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var name: String = ""
    var petType: String = ""
    var age: Int = 0
}