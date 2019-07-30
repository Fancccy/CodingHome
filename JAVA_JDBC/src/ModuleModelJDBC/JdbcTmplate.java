package ModuleModelJDBC;

import java.sql.ResultSet;

public class JdbcTmplate extends AbstractJdbcTemplate {
    @Override
    public <T> T handlerResult(ResultSet resultSet) {
        return null;
    }

    @Override
    public <T> T handlerResult(int effect) {
        return null;
    }
}
