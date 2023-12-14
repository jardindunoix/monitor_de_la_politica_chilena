package cl.antoinette.monitor_politico_econmico.ui.use_cases.diputados

import cl.antoinette.monitor_politico_econmico.service.StaticUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.stream.Collectors

class DiputadosActualesWebScrapCall { companion object {
	/*LEGISLATIVO*/
	fun getDiputadosActuales():MutableList<DiputadoActualEntity> {
		val diputadosActualesList = mutableListOf<DiputadoActualEntity>()
		val url = "${StaticUtils.BASE_URL_DIP_ACT}${StaticUtils.END_POINT_DIP_ACT}"
		val document:Document = Jsoup.connect(url).get()
		val articleElement:Elements = document.select("article.${StaticUtils.GRID_DIP_ACT}")
		val h4Elements = articleElement.select(StaticUtils.H4_DIP_ACT).eachText()
		val nameList = h4Elements.stream().collect(Collectors.toList())
		val webpage = articleElement.select("a").eachAttr(StaticUtils.HREF_DIP_ACT).stream()
			.collect(Collectors.toList())
		val imagesList =
			articleElement.select(StaticUtils.IMG_DIP_ACT).eachAttr(StaticUtils.SRC_DIP_ACT)
				.stream().collect(Collectors.toList())
		var countAttr = 0
		if (webpage.size / 3 == nameList.size) {
			val oldValueOne = "Sr. "
			val oldValueTwo = "Sra. "
			val newValue = ""
			
			for ((i, f) in imagesList.withIndex()) {
				diputadosActualesList.add(
					DiputadoActualEntity(
					nombre = nameList[i].replace(oldValueOne, newValue)
						.replace(oldValueTwo, newValue),
					paginaWeb = "${StaticUtils.BASE_URL_DIP_ACT}${StaticUtils.DIPUTADOS_DIP_ACT}${webpage[countAttr]}",
					picture = "${StaticUtils.BASE_URL_DIP_ACT}${f}")
				)
				countAttr += 3
			}
		}
		return diputadosActualesList
	}
	
}
}