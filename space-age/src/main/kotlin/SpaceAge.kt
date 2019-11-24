import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(private val secondsOld: Long) {
    constructor(secondsOld: Int) : this(secondsOld.toLong())


    /**
     * 地球の年齢
     */
    companion object {
        const val earthYear = 31557600.0
    }

    /**
     * 惑星の軌道の周期
     */
    enum class OrbitalPeriodRatio(val ratio: Double) {
        EARTH(1.0),
        MERCURY(0.2408467),
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132)
    }

    private fun calculatePlanetYear(period: OrbitalPeriodRatio): Double {
        return BigDecimal.valueOf(secondsOld / (earthYear * period.ratio)).setScale(2, RoundingMode.HALF_UP)
            .toDouble()
    }

    fun onEarth(): Double = calculatePlanetYear(OrbitalPeriodRatio.EARTH)
    fun onMercury(): Double = calculatePlanetYear(OrbitalPeriodRatio.MERCURY)
    fun onVenus(): Double = calculatePlanetYear(OrbitalPeriodRatio.VENUS)
    fun onMars(): Double = calculatePlanetYear(OrbitalPeriodRatio.MARS)
    fun onJupiter(): Double = calculatePlanetYear(OrbitalPeriodRatio.JUPITER)
    fun onSaturn(): Double = calculatePlanetYear(OrbitalPeriodRatio.SATURN)
    fun onUranus(): Double = calculatePlanetYear(OrbitalPeriodRatio.URANUS)
    fun onNeptune(): Double = calculatePlanetYear(OrbitalPeriodRatio.NEPTUNE)


}