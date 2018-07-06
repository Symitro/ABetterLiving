/*
 * Copyright 2018 Peter Heinrich <peter.heinrich@zhaw.ch>.
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
package ch.zhaw.mobileeng.abetterliving.dto;

import ch.zhaw.mobileeng.abetterliving.model.Users;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Peter Heinrich <peter.heinrich@zhaw.ch>
 */
@Data
public class AuthorizationToken {

    private String token;
    private Date expiresAt;
    private Users user;
}
