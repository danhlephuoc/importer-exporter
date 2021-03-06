/*
 * 3D City Database - The Open Source CityGML Database
 * http://www.3dcitydb.org/
 *
 * Copyright 2013 - 2019
 * Chair of Geoinformatics
 * Technical University of Munich, Germany
 * https://www.gis.bgu.tum.de/
 *
 * The 3D City Database is jointly developed with the following
 * cooperation partners:
 *
 * virtualcitySYSTEMS GmbH, Berlin <http://www.virtualcitysystems.de/>
 * M.O.S.S. Computer Grafik Systeme GmbH, Taufkirchen <http://www.moss.de/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citydb.gui.components.menubar;

import org.citydb.config.Config;
import org.citydb.config.i18n.Language;
import org.citydb.gui.ImpExpGui;
import org.citydb.gui.util.GuiUtil;
import org.citydb.gui.util.OSXAdapter;
import org.citydb.plugin.PluginManager;
import org.citydb.plugin.extension.menu.MenuExtension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.xml.bind.JAXBContext;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	private final PluginManager pluginManager;

	private MenuFile file;
	private MenuProject project;
	private MenuView view;
	private MenuHelp help;

	private JMenu extensions;

	public MenuBar(ImpExpGui mainView, JAXBContext ctx, Config config) {
		pluginManager = PluginManager.getInstance();
		
		file = new MenuFile();
		project = new MenuProject(pluginManager, ctx, mainView, config);
		view = new MenuView(mainView, config);
		help = new MenuHelp(mainView, config);

		// as long as the file menu only allows to close the application
		// we do not need it on Mac OS X
		if (!OSXAdapter.IS_MAC_OS_X)
			add(file);
		
		add(project);

		for (MenuExtension extension : pluginManager.getExternalMenuExtensions()) {
			if (extensions == null)
				extensions = new JMenu();

			JMenu menu = extension.getMenu().getMenuComponent();
			menu.setText(extension.getMenu().getLocalizedTitle());
			menu.setIcon(extension.getMenu().getIcon());
			GuiUtil.setMnemonic(menu, menu.getText(), extension.getMenu().getMnemonicIndex());
			extensions.add(menu);
		}

		if (extensions != null)
			add(extensions);

		add(view);
		add(help);

		view.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				view.update();
			}

			@Override
			public void menuDeselected(MenuEvent e) { }

			@Override
			public void menuCanceled(MenuEvent e) { }
		});
	}

	public void doTranslation() {
		file.setText(Language.I18N.getString("menu.file.label"));
		project.setText(Language.I18N.getString("menu.project.label"));
		view.setText(Language.I18N.getString("menu.view.label"));
		help.setText(Language.I18N.getString("menu.help.label"));

		GuiUtil.setMnemonic(file, "menu.file.label", "menu.file.label.mnemonic");
		GuiUtil.setMnemonic(project, "menu.project.label", "menu.project.label.mnemonic");
		GuiUtil.setMnemonic(view, "menu.view.label", "menu.view.label.mnemonic");
		GuiUtil.setMnemonic(help, "menu.help.label", "menu.help.label.mnemonic");

		if (extensions != null) {
			extensions.setText(Language.I18N.getString("menu.extensions.label"));
			GuiUtil.setMnemonic(extensions, "menu.extensions.label", "menu.extensions.label.mnemonic");

			int index = 0;
			for (MenuExtension extension : pluginManager.getExternalMenuExtensions())
				((JMenu)extensions.getMenuComponent(index++)).setText(extension.getMenu().getLocalizedTitle());
		}

		file.doTranslation();
		project.doTranslation();
		view.doTranslation();
		help.doTranslation();
	}

	public void printInfo() {
		help.printInfo();
	}

}
