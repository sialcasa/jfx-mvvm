/*
 * Copyright 2013 Alexander Casall - Saxonia Systems AG
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 */

package de.saxsys.jfx.mvvm.viewloader;

/**
 * Possible ViewControllers.
 */
public enum MVVMViewNames {
	PERSONWELCOME(
			"/de/saxsys/jfx/exampleapplication/view/personwelcome/PersonWelcomeView.fxml"), PERSONLOGIN(
			"/de/saxsys/jfx/exampleapplication/view/personlogin/PersonLoginView.fxml"), MAINCONTAINER(
			"/de/saxsys/jfx/exampleapplication/view/maincontainer/MainContainerView.fxml");

	private String resource;

	private MVVMViewNames(final String resource) {
		this.resource = resource;
	}

	/**
	 * @return resource represented by a string
	 */
	public String getResource() {
		return resource;
	}
}
