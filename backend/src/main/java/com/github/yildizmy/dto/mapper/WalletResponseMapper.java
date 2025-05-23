package com.github.yildizmy.dto.mapper;

import com.github.yildizmy.dto.response.UserResponse;
import com.github.yildizmy.dto.response.WalletResponse;
import com.github.yildizmy.domain.entity.User;
import com.github.yildizmy.domain.entity.Wallet;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.text.MessageFormat;

/**
 * Mapper used for mapping WalletResponse fields.
 */
@Mapper(componentModel = "spring")
public interface WalletResponseMapper {

    Wallet toWallet(WalletResponse dto);

    WalletResponse toWalletResponse(Wallet entity);

    @AfterMapping
    default void setFullName(@MappingTarget UserResponse dto, User entity) {
        dto.setFullName(MessageFormat.format("{0} {1}", entity.getFirstName(), entity.getLastName()));
    }
}
