package com.example.Splitwise.service;

import com.example.Splitwise.dto.TransactionDTO;
import com.example.Splitwise.exception.GroupNotFoundException;

import java.util.List;

public interface GroupService {

    List<TransactionDTO> settleUpByGroupId(int groupId) throws GroupNotFoundException;
}
