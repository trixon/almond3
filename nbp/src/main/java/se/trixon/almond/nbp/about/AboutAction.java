/*
 * Copyright 2017 Patrik Karlsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.trixon.almond.nbp.about;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import se.trixon.almond.util.Dict;
import se.trixon.almond.util.swing.dialogs.about.AboutModel;
import se.trixon.almond.util.swing.dialogs.about.AboutPanel;

/**
 *
 * @author Patrik Karlsson
 */
public final class AboutAction implements ActionListener {

    private static AboutModel sAboutModel;

    public static void setAboutModel(AboutModel aboutModel) {
        AboutAction.sAboutModel = aboutModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AboutPanel aboutPanel = new AboutPanel(sAboutModel);
        aboutPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 0, 16));

        DialogDescriptor dialogDescriptor = new DialogDescriptor(
                aboutPanel,
                String.format(Dict.ABOUT_S.toString(), sAboutModel.getAppName()),
                false,
                new Object[]{DialogDescriptor.CLOSED_OPTION},
                DialogDescriptor.CLOSED_OPTION,
                DialogDescriptor.DEFAULT_ALIGN,
                null,
                null);

        DialogDisplayer.getDefault().notify(dialogDescriptor);
    }
}
