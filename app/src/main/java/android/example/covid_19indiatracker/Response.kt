package android.example.covid_19indiatracker
//Parsed json using ROBO POJO Generator
data class Response(
	val statewise: List<StatewiseItem>
)

data class StatewiseItem(
	val recovered: String? = null,
	val deltadeaths: String? = null,
	val deltarecovered: String? = null,
	val active: String? = null,
    val deltaactive: String? = null,
	val deltaconfirmed: String? = null,
	val state: String? = null,
	val statecode: String? = null,
	val confirmed: String? = null,
	val deaths: String? = null,
	val lastupdatedtime: String? = null
)

