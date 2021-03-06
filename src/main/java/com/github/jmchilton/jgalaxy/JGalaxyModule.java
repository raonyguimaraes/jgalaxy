/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jmchilton.jgalaxy;

import com.github.jmchilton.jgalaxy.JGalaxy.InputState;
import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;

public class JGalaxyModule extends AbstractModule {
  private final InputState inputState;
  
  JGalaxyModule(final InputState inputState) {
    this.inputState = inputState;
  }
  
  @Override
  protected void configure() {
    bind(InputState.class).toInstance(inputState);
    bind(EventBus.class).toInstance(new com.github.jmchilton.jgalaxy.mvp.EventBus());
    bind(BulkDownloadPresenter.class).asEagerSingleton();
    bind(UploadPresenter.class).asEagerSingleton();
    bind(ConnectionPresenter.class).asEagerSingleton();
    bind(JGalaxy.class);
  }
  
}
