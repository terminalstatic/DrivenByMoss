// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2025
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.controller.akai.apc.command.trigger;

import de.mossgrabers.controller.akai.apc.APCConfiguration;
import de.mossgrabers.controller.akai.apc.controller.APCControlSurface;
import de.mossgrabers.framework.command.core.AbstractTriggerCommand;
import de.mossgrabers.framework.daw.IModel;
import de.mossgrabers.framework.featuregroup.ModeManager;
import de.mossgrabers.framework.mode.Modes;
import de.mossgrabers.framework.utils.ButtonEvent;


/**
 * Select a send mode.
 *
 * @author Jürgen Moßgraber
 */
public class SendModeCommand extends AbstractTriggerCommand<APCControlSurface, APCConfiguration>
{
    private final int sendIndex;


    /**
     * Constructor.
     *
     * @param sendIndex The channel index
     * @param model The model
     * @param surface The surface
     */
    public SendModeCommand (final int sendIndex, final IModel model, final APCControlSurface surface)
    {
        super (model, surface);
        this.sendIndex = sendIndex;
    }


    /** {@inheritDoc} */
    @Override
    public void executeNormal (final ButtonEvent event)
    {
        this.handleExecute (event, this.sendIndex);
    }


    /** {@inheritDoc} */
    @Override
    public void executeShifted (final ButtonEvent event)
    {
        this.handleExecute (event, this.sendIndex + 3);
    }


    private void handleExecute (final ButtonEvent event, final int sendIndex)
    {
        // No Sends on FX tracks
        if (event != ButtonEvent.DOWN || this.model.isEffectTrackBankActive ())
            return;

        final ModeManager modeManager = this.surface.getModeManager ();
        modeManager.setActive (Modes.get (Modes.SEND1, sendIndex));
        this.mvHelper.notifySelectedSend (sendIndex);
    }
}
