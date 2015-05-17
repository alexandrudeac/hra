package ro.adc.mybatis.jodatime;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.annotation.Nullable;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.joda.time.LocalDateTime;



@MappedTypes(LocalDateTime.class)
public class LocalDateTimeTypeHandler extends BaseTypeHandler<LocalDateTime> {

    @Override
    public void setNonNullParameter(final PreparedStatement ps, final int i, final LocalDateTime parameter,
            final JdbcType jdbcType) throws SQLException {
        ps.setTimestamp(i, new Timestamp(parameter.toDate().getTime()));
    }

    @Override
    public LocalDateTime getNullableResult(final ResultSet rs, final String columnName) throws SQLException {
        return fromSqlTimestamp(rs.getTimestamp(columnName));
    }

    @Override
    public LocalDateTime getNullableResult(final ResultSet rs, final int columnIndex) throws SQLException {
        return fromSqlTimestamp(rs.getTimestamp(columnIndex));
    }

    @Override
    public LocalDateTime getNullableResult(final CallableStatement cs, final int columnIndex) throws SQLException {
        return fromSqlTimestamp(cs.getTimestamp(columnIndex));
    }

    private LocalDateTime fromSqlTimestamp(@Nullable final Timestamp sqlTimestamp) {
        LocalDateTime localDateTime;
        if (sqlTimestamp != null) {
            localDateTime=  new LocalDateTime(sqlTimestamp.getTime());
        } else {
            localDateTime = null;
        }
        return localDateTime;
    }
}
