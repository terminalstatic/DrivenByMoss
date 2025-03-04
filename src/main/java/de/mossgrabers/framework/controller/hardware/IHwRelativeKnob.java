// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2025
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.framework.controller.hardware;

import de.mossgrabers.framework.observer.IValueObserver;


/**
 * Interface for a proxy to a knob on a hardware controller.
 *
 * @author Jürgen Moßgraber
 */
public interface IHwRelativeKnob extends IHwContinuousControl
{
    /**
     * Registers an observer to get notified when the value changes.
     *
     * @param observer The observer to register
     */
    void addHasChangedObserver (IValueObserver<Void> observer);


    /**
     * Set the sensitivity of the relative knob.
     *
     * @param sensitivity The sensitivity in the range [-100..100], 0 is the default, negative
     *            values are slower, positive faster
     */
    void setSensitivity (double sensitivity);


    /**
     * Check if the knob should be adjusted to the sensitivity settings.
     *
     * @return True if the knob should be adjusted to the sensitivity settings
     */
    boolean shouldAdaptSensitivity ();


    /**
     * Set if the knob should be adjusted to the sensitivity settings.
     *
     * @param shouldAdaptSensitivity True if the knob should be adjusted to the sensitivity settings
     */
    void setShouldAdaptSensitivity (boolean shouldAdaptSensitivity);
}
