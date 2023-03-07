package org.play.wsi;

import static org.assertj.core.api.Assertions.assertThat;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import java.util.function.Predicate;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.slf4j.LoggerFactory;

public final class LogsSpy implements BeforeEachCallback, AfterEachCallback, ParameterResolver {

  private Logger logger;
  private ListAppender<ILoggingEvent> appender;
  private Level initialLevel;

  @Override
  public void beforeEach(ExtensionContext context) {
    appender = new ListAppender<>();
    logger = (Logger) LoggerFactory.getLogger("org.play.wsi");
    logger.addAppender(appender);
    initialLevel = logger.getLevel();
    logger.setLevel(Level.TRACE);
    appender.start();
  }

  @Override
  public void afterEach(ExtensionContext context) {
    logger.setLevel(initialLevel);
    logger.detachAppender(appender);
  }

  public LogsSpy shouldHave(Level level, String content) {
    assertThat(appender.list).anyMatch(withLog(level, content));

    return this;
  }

  public LogsSpy shouldHave(Level level, String content, int count) {
    assertThat(appender.list.stream().filter(withLog(level, content))).hasSize(count);

    return this;
  }

  public LogsSpy shouldNotHave(Level level, String content) {
    assertThat(appender.list).noneMatch(withLog(level, content));

    return this;
  }

  private Predicate<ILoggingEvent> withLog(Level level, String content) {
    return event -> level.equals(event.getLevel()) && event.toString().contains(content);
  }

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
    throws ParameterResolutionException {
    return parameterContext.getParameter().getType().equals(LogsSpy.class);
  }

  @Override
  public LogsSpy resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
    throws ParameterResolutionException {
    return this;
  }
}
