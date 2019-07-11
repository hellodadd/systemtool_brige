package com.system.android.systemtool;

import android.content.res.SToolResources;

import com.system.android.systemtool.callbacks.STool_InitPackageRes;
import com.system.android.systemtool.callbacks.STool_InitPackageRes.InitPackageResourcesParam;

/**
 * Get notified when the resources for an app are initialized.
 * In {@link #handleInitPackageResources}, resource replacements can be created.
 *
 * <p>This interface should be implemented by the module's main class. SystemTool will take care of
 * registering it as a callback automatically.
 */
public interface ISystemToolHkInitPackageResources extends ISystemToolMod {
	/**
	 * This method is called when resources for an app are being initialized.
	 * Modules can call special methods of the {@link SToolResources} class in order to replace resources.
	 *
	 * @param resparam Information about the resources.
	 * @throws Throwable Everything the callback throws is caught and logged.
	 */
	void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable;

	/** @hide */
	final class Wrapper extends STool_InitPackageRes {
		private final ISystemToolHkInitPackageResources instance;
		public Wrapper(ISystemToolHkInitPackageResources instance) {
			this.instance = instance;
		}
		@Override
		public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable {
			instance.handleInitPackageResources(resparam);
		}
	}
}
