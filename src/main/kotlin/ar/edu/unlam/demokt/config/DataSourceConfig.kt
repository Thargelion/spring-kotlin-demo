package ar.edu.unlam.demokt.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@Configuration
class DataSourceConfig {

    private val JDBC_MYSQL: String = "jdbc:mysql://"
    private val SLASH: String = "/"
    private val MYSQL_PARAMETERS =
        "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"

    @Value("\${spring.datasource.username}")
    val userName: String? = "root"

    @Value("\${spring.datasource.password}")
    val password: String? = ""

    @Value("\${spring.datasource.host}")
    val databaseHost: String? = "127.0.0.1:3306"

    @Value("\${spring.datasource.database}")
    val databaseName: String? = "postsdb"


    @Bean(name = arrayOf("dsCustom"))
    fun dataSource(): DataSource {
        val dataSource: HikariDataSource? = DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .username(userName)
            .password(password)
            .url(JDBC_MYSQL + this.databaseHost + SLASH + this.databaseName + MYSQL_PARAMETERS)
            .build()
        dataSource!!.setMaximumPoolSize(100)
        return dataSource
    }

    @Autowired
    @Bean(name = arrayOf("jdbcCustom"))
    fun jdbcTemplate(@Qualifier("dsCustom") dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

}