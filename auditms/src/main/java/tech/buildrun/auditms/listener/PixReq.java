package tech.buildrun.auditms.listener;

import java.math.BigDecimal;

public record PixReq(String channel, String from, String to, BigDecimal value) {
}
