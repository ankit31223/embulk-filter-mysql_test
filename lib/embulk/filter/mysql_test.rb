Embulk::JavaPlugin.register_filter(
  "mysql_test", "org.embulk.filter.mysql_test.MysqlTestFilterPlugin",
  File.expand_path('../../../../classpath', __FILE__))
