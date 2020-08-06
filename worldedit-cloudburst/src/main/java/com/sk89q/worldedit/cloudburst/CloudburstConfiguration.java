/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.cloudburst;

import com.sk89q.util.yaml.YAMLProcessor;
import com.sk89q.worldedit.util.YAMLConfiguration;
import com.sk89q.worldedit.util.report.Unreported;
import org.slf4j.LoggerFactory;

import java.io.File;

public class CloudburstConfiguration extends YAMLConfiguration {

    public boolean noOpPermissions = false;
    public boolean commandBlockSupport = false;
    @Unreported
    private final CloudburstWorldEdit plugin;

    public CloudburstConfiguration(YAMLProcessor config, CloudburstWorldEdit plugin) {
        super(config, LoggerFactory.getLogger(plugin.getLogger().getName()));
        this.plugin = plugin;
    }

    @Override
    public void load() {
        super.load();
        noOpPermissions = config.getBoolean("no-op-permissions", false);
        commandBlockSupport = config.getBoolean("command-block-support", false);
    }

    @Override
    public File getWorkingDirectory() {
        return plugin.getDataFolder();
    }
}
