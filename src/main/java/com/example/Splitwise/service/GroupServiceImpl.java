package com.example.Splitwise.service;

import com.example.Splitwise.dto.TransactionDTO;
import com.example.Splitwise.exception.GroupNotFoundException;
import com.example.Splitwise.model.Group;
import com.example.Splitwise.repository.GroupRepository;
import com.example.Splitwise.service.strategy.SettleUpStrategy;
import com.example.Splitwise.service.strategy.SettleUpStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<TransactionDTO> settleUpByGroupId(int groupId) throws GroupNotFoundException {
        SettleUpStrategy strategy = SettleUpStrategyFactory.getSettleUpStrategy();
        Optional<Group> savedGroup = groupRepository.findById(groupId);
        if(savedGroup.isEmpty()){
            throw new GroupNotFoundException("Group for given id was not found. Id : " + groupId);
        }
        return strategy.settleUp(savedGroup.get().getExpenses());

    }
}
